package com.fsk.simpleviewholders

import android.view.View

/**
 * A simple view holder that makes that item view clickable
 *
 * @param itemView the root view for the view holder
 * @param onItemClick callback to handle the item view click.  It passes the adapter position of the item as a parameter.
 */
open class OnItemClickViewHolder(
    itemView: View,
    onItemClick: (Int) -> Unit
) : SimpleViewHolder(itemView) {

    init {
        itemView.setOnClickListener { onItemClick(adapterPosition) }
    }
}