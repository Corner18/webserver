import java.util.ArrayList;

public class Message {

    public Message(String sender, String recipient, String message){
            this.sender = sender;
            this.recipient = recipient;
            this.message = message;
        }


        private String sender;
        private String recipient;
        private String message;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private static Message mInstance;
        private ArrayList<Message> messages = null;

        public static Message getInstance() {
            if(mInstance == null)
                mInstance = new Message();

            return mInstance;
        }

        private Message() {
            messages = new ArrayList<Message>();
            messages.add(new Message("1","2","Hi, Aliya"));
            messages.add(new Message("2","1","Hi,Nastya"));
            messages.add(new Message("1","3","Hi, Salavat"));
            messages.add(new Message("1","4","Hi, Emil"));
            messages.add(new Message("1","5","Hi, Kamila"));
            messages.add(new Message("2","3","Hi, Salavat"));
            messages.add(new Message("2","4","Hi, Emil"));
            messages.add(new Message("2","5","Hi, Kamila"));
            messages.add(new Message("3","1","Hi, Nastya"));
            messages.add(new Message("3","2","Hi, Aliya"));
            messages.add(new Message("3","4","Hi, Emil"));
            messages.add(new Message("3","5","Hi, Kamila"));
            messages.add(new Message("4","1","Hi, Nastya"));
            messages.add(new Message("4","2","Hi, Aliya"));
            messages.add(new Message("4","3","Hi, Salavat"));
            messages.add(new Message("4","5","Hi, Kamila"));
            messages.add(new Message("5","1","Hi, Nastya"));
            messages.add(new Message("5","2","Hi, Aliya"));
            messages.add(new Message("5","3","Hi, Salavat"));
            messages.add(new Message("5","4","Hi, Emil"));


        }

        public ArrayList<Message> getArrayMessage() {
            return this.messages;
        }

    }
