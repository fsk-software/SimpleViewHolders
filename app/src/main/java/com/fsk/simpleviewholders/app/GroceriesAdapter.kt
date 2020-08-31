package com.fsk.simpleviewholders.app

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fsk.simpleviewholders.OnItemClickViewHolder
import com.fsk.simpleviewholders.SimpleViewHolder

class GroceriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val MISSING_ITEMS_HEADER_VIEW_TYPE = 0
        private const val FOUND_ITEMS_HEADER_VIEW_TYPE = 1

        private const val MISSING_ITEM_VIEW_TYPE = 2
        private const val FOUND_ITEM_VIEW_TYPE = 3
    }


    private class ItemViewHolder(
        itemView: View,
        onItemClicked: (Int) -> Unit
    ) : OnItemClickViewHolder(itemView, onItemClicked) {

        val itemNameView = itemView.findViewById<TextView>(R.id.itemName)
    }

    var missingItems: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    var foundItems: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int =
        when {
            position == 0 -> MISSING_ITEMS_HEADER_VIEW_TYPE
            position <= missingItems.size -> MISSING_ITEM_VIEW_TYPE
            position == missingItems.size + 1 -> FOUND_ITEMS_HEADER_VIEW_TYPE
            else -> FOUND_ITEM_VIEW_TYPE
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        LayoutInflater.from(parent.context).let {
            when (viewType) {
                MISSING_ITEMS_HEADER_VIEW_TYPE ->
                    SimpleViewHolder(it.inflate(R.layout.item_missing_items_header, parent, false))

                MISSING_ITEM_VIEW_TYPE ->
                    ItemViewHolder(it.inflate(R.layout.item_missing_item, parent, false))
                    { position ->
                        val item = missingItems[position - 1]
                        missingItems = missingItems.toMutableList().apply { removeAt(position - 1) }
                        foundItems = foundItems.toMutableList().apply { add(item) }
                    }

                FOUND_ITEMS_HEADER_VIEW_TYPE ->
                    SimpleViewHolder(it.inflate(R.layout.item_found_items_header, parent, false))

                FOUND_ITEM_VIEW_TYPE ->
                    ItemViewHolder(it.inflate(R.layout.item_found_item, parent, false))
                    { position ->
                        val index = position - 2 - missingItems.size
                        val item = foundItems[index]
                        foundItems = foundItems.toMutableList().apply { removeAt(index) }
                        missingItems = missingItems.toMutableList().apply { add(item) }
                    }

                else -> throw IllegalStateException("Unknown view type")
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            MISSING_ITEM_VIEW_TYPE -> {
                (holder as ItemViewHolder).apply {
                    itemNameView.text = missingItems[position - 1]
                }
            }

            FOUND_ITEM_VIEW_TYPE -> {
                (holder as ItemViewHolder).apply {
                    val span = SpannableString(foundItems[position - 2 - missingItems.size])
                    span.setSpan(
                        StrikethroughSpan(),
                        0,
                        span.length,
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                    )
                    itemNameView.text = span

                }
            }
        }
    }

    override fun getItemCount(): Int = missingItems.size + foundItems.size + 2
}