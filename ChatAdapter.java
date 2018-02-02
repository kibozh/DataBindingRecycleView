package com.scanor.chat.adapter;

import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/10/17.
 */

public class ChatAdapter extends BaseRecyclerBindingAdapter<MessageTable> {

    //两个type，一个是是否自己发的，第二个是消息类型，余数是是否自己发，商是消息类型
    @Override
    public int getItemViewType(int position) {
        MessageTable msg = getDataList().get(position);
        Type type = Type.fromString(msg.getType());
        int selfSend = msg.isSendByMyself() ? 1 : 0;//是否自己发的标志位
        return type.getValue() * 10 + selfSend;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int selfSend = viewType % 10;
        int typeValue = viewType / 10;
        Type type = Type.fromValue(typeValue);
        boolean isSelfSend = selfSend == 1;
        switch (type) {
            case text:
                return BindingHolder.newInstance(isSelfSend ? R.layout.newchat_send_msg_text : R.layout.newchat_receive_msg_text, parent);
            case image:
                return BindingHolder.newInstance(isSelfSend ? R.layout.newchat_send_msg_image : R.layout.newchat_receive_msg_image, parent);
            case voice:
                return BindingHolder.newInstance(isSelfSend ? R.layout.newchat_send_msg_audio : R.layout.newchat_receive_msg_audio, parent);
            case video:
                return BindingHolder.newInstance(isSelfSend ? R.layout.newchat_send_msg_video : R.layout.newchat_receive_msg_video, parent);
            case DTCard:
                return BindingHolder.newInstance(isSelfSend ? R.layout.newchat_send_msg_card : R.layout.newchat_receive_msg_card, parent);
            case search:
                return BindingHolder.newInstance(R.layout.newchat_receive_msg_search, parent);
            case address:
                return BindingHolder.newInstance(isSelfSend ? R.layout.newchat_send_msg_address : R.layout.newchat_receive_msg_address, parent);
            case notification:
                return BindingHolder.newInstance(R.layout.newchat_sendandrecv_msg_notification, parent);
            case redpacket:
                return BindingHolder.newInstance(isSelfSend ? R.layout.newchat_send_msg_red_packet : R.layout.newchat_receive_msg_red_packet, parent);
            default:
                return BindingHolder.newInstance(isSelfSend ? R.layout.newchat_send_msg_text : R.layout.newchat_receive_msg_text, parent);
        }
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final MessageTable message = getDataList().get(position);
        final Type type = Type.fromString(message.getType());
        if (message.isSendByMyself()) {
            switch (type) {
                case A:
                    XXXBinding1 binding = holder.getBinding();
                    ...
                    break;
                case A:
                    XXXBinding2 binding = holder.getBinding();
                    ...
                    break;
                ...
            }
        } else {
            handleContactMsg(holder, message, type, position);
        }
    }

}
