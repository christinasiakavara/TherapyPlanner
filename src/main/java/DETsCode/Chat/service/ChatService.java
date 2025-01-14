package DETsCode.Chat.service;

import java.util.List;

import DETsCode.Chat.Chat;
import DETsCode.Chat.ChatDAO;
import DETsCode.Message.Message;
import DETsCode.Message.MessageDao;

public class ChatService {

    private final ChatDAO chatDAO;
    private final MessageDao messageDao;

    public ChatService() {
        this.chatDAO = new ChatDAO();
        this.messageDao = new MessageDao();
    }

    public List<Chat> getChatById(int chatId) {
        return chatDAO.getChatById(chatId);
    }

    public Boolean createChat(Chat chat) {
        return chatDAO.addChat(chat);
    }

    public List<Message> getMessageHistory(int chatId) {
        return messageDao.getMessagesByChatId(chatId);
    }
}