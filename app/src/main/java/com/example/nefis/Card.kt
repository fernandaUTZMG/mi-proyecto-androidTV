package com.example.nefis

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter

class Card: Presenter(){
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val card=ImageCardView(parent.context)
        card.isFocusable=true
        card.isFocusableInTouchMode=true

        return ViewHolder(card)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        val video=item as Video
        with(viewHolder.view as ImageCardView){
            titleText=video.title
            contentText=video.subtitle
            setMainImageDimensions(300, 150)
            setBackgroundResource(video.image)

        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {

    }

}