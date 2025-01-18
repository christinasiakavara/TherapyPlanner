package DETsCode.Message.service;

import DETsCode.Message.Message;
import DETsCode.Message.MessageDao;

import java.util.List;

public class MessageService {

    private final MessageDao messageDAO;

    public MessageService(MessageDao messageDAO) {
        this.messageDAO = messageDAO;
    }

    public boolean sendMessage(Message message) {
        if (message == null || message.getContent() == null || message.getTimestamp() == null) {
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

    public boolean deleteMessage(Message message) {
        if (message.getMessageid() <= 0) {
            throw new IllegalArgumentException("Invalid message ID");
        }
        return messageDAO.deleteMessage(message);
    }
}
