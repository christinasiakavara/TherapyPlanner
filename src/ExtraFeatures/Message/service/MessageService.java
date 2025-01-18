package DETsCode.ExtraFeatures.Message.service;

import java.util.List;

import DETsCode.ExtraFeatures.*;
public class MessageService {

    private final MessageDao messageDAO;

    public MessageService(MessageDao messageDAO) {
        this.messageDAO = messageDAO;
    }

    public boolean sendMessage(Message message) {
        if (message == null|| message.getContent() == null || message.getTimestamp() == null) {
            throw new IllegalArgumentException("Invalid message data");
        }
        return messageDAO.addmessage(message);
    }

    public List<Message> getMessagesByChatId(int chatId) {
        if (chatId <= 0) {
            throw new IllegalArgumentException("Invalid chat ID");
        }
        return messageDAO.getMessagesByChatId(chatId);
    }

    public boolean deleteMessage(int messageId) {
        if (messageId <= 0) {
            throw new IllegalArgumentException("Invalid message ID");
        }
        return messageDAO.deleteMessage(messageId);
    }
}
