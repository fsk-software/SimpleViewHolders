package com.fsk.simpleviewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple view holder that provides a concrete view holder, but doesn't require any extra fields.
 *
 * @param itemView the root view for the view holder
 */
open class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)