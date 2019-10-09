import java.util.ArrayList;

public class Subscription {

        public Subscription(String folowing, String folowed){
            this.folowing = folowing;
            this.folowed = folowed;
        }


        private String folowing;
        private String folowed;

    public String getFolowing() {
        return folowing;
    }

    public void setFolowing(String folowing) {
        this.folowing = folowing;
    }

    public String getFolowed() {
        return folowed;
    }

    public void setFolowed(String folowed) {
        this.folowed = folowed;
    }

    private static Subscription mInstance;
        private ArrayList<Subscription> subscriptions = null;

        public static Subscription getInstance() {
            if(mInstance == null)
                mInstance = new Subscription();

            return mInstance;
        }

        private Subscription() {
            subscriptions = new ArrayList<Subscription>();
            subscriptions.add(new Subscription("1","2"));
            subscriptions.add(new Subscription("1","4"));
            subscriptions.add(new Subscription("1","5"));
            subscriptions.add(new Subscription("2","1"));
            subscriptions.add(new Subscription("2","3"));
            subscriptions.add(new Subscription("2","4"));
            subscriptions.add(new Subscription("3","2"));
            subscriptions.add(new Subscription("3","4"));
            subscriptions.add(new Subscription("4","1"));
            subscriptions.add(new Subscription("4","5"));
            subscriptions.add(new Subscription("5","1"));
            subscriptions.add(new Subscription("5","4"));


        }

        public ArrayList<Subscription> getArraySubscriptions() {
            return this.subscriptions;
        }

    }

