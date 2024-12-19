package DETsCode.Chat;
import DETsCode.Message.Message;
import DETsCode.Message.MessageDao;
import DETsCode.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDAO {
    private final DatabaseConnection conn;

    public ChatDAO() {
        this.conn = DatabaseConnection.getInstance();
    }
    public List<Chat> getallChats() {
        List<Chat> chats = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement( "SELECT * FROM Chat");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int chatId = rs.getInt("chatid");
                int partparticipantpatientid = rs.getInt("participantpatient"); 
                int participanttherapistid = rs.getInt("participanttherapist");
                List<Message> messages = MessageDao.getMessagesByChatId(chatId);
                chats.add(new Chat(chatId, partparticipantpatientid, participanttherapistid , messages));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chats;
    }

    public List<Chat> getChatById(int chatId) {
        List<Chat> chats = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement(
                "SELECT * FROM Chat WHERE chatId = ?"
            );
            stmt.setInt(1, chatId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int partparticipantpatientid = rs.getInt("participantpatient"); 
                int participanttherapistid = rs.getInt("participanttherapist");
                List<Message> messages = MessageDao.getMessagesByChatId(chatId);
                chats.add(new Chat(chatId, partparticipantpatientid, participanttherapistid , messages));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chats;
    }
    public boolean addChat(Chat chat) {
        String query = "INSERT INTO chat (chatID, participantTherapistID, participantPsychologistID) VALUES (?, ?, ?);";
        try { PreparedStatement stmt = conn.getConnection().prepareStatement(query); 

            stmt.setInt(1, chat.getChatid());
            stmt.setInt(2, chat.getParticipantpatientid());
            stmt.setInt(3, chat.getParticipantpatientid());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
