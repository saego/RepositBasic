package start;

import moduls.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 Created by ${Ruslan} on 04.10.16.

 */
public class StartUI {
    private Tracker tracker = new Tracker();
    private Date date = new Date();
    private SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yy hh:mm");
    public static void main(String[] args) {
        StartUI start = new StartUI();
        start.addClients();
        start.searchClients();
        start.removeClients();
        start.updateClient();
        start.addComments();
    }
        private void addClients(){

            Item[] items = new Item[6];
        items[0] = new Item("Oxana", date.getTime(), "description 1");
        items[1] = new Item("Owen", date.getTime(), "description 2");
        items[2] = new Item("Mike", date.getTime(), "description 3");
        items[3] = new Item("Nick", date.getTime(), "description 4");
        items[4] = new Item("Mike", date.getTime(), "description 5");
        items[5] = new Item("Johnathan", date.getTime(), "description 6");

            System.out.println("                                       " +
                    " ______/Add clients and show all clients/______");
            for (Item item:
                 items) {
                tracker.addClient(item);
            }
            System.out.println();
            System.out.println("________* Client Base *________");
            System.out.println();
            for (Item trackerItems:
                 tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println("Client Id: " + trackerItems.getClientId()
                            + "   Client name: " + trackerItems.getName()
                            + "   Date add: " + myFormat.format(trackerItems.getDateAdd())
                            + "   Description: " + trackerItems.getDescription());
                    System.out.println("*-*-*");
                }
            }
            System.out.println("                                       " +
                    " ______/*End of table*/______");
            System.out.println();
        }

        private void searchClients(){

            System.out.println("                                       " +
                    " ______/Search client by Id/______");
            String clientId = tracker.getAll()[3].getClientId();
            System.out.println();
            System.out.println("________* Look what I've found *________");
            System.out.println();
            System.out.println("Client Id: " + tracker.findById(clientId).getClientId()
                    + "   Client name: " + tracker.findById(clientId).getName()
                    + "   Date add: " + tracker.findById(clientId).getDateAdd()
                    + "   Description: " + tracker.findById(clientId).getDescription());
            System.out.println("*-*-*");
            System.out.println("                                       " +
                    " ______/*End of table*/______");
            System.out.println();
        }

        private void removeClients(){

            System.out.println("                                       " +
                    " ______/Remove client by Id/______");
            String clientId = tracker.getAll()[4].getClientId();
            System.out.println();
            System.out.println("________* Look what I've done *________");
            System.out.println();
            tracker.remove(clientId);
            for (Item trackerItems:
                    tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println("Client Id: " + trackerItems.getClientId()
                            + "   Client name: " + trackerItems.getName()
                            + "   Date add: " + myFormat.format(trackerItems.getDateAdd())
                            + "   Description: " + trackerItems.getDescription());
                    System.out.println("*-*-*");
                }
            }
            System.out.println("                                       " +
                    " ______/*End of table*/______");
            System.out.println();
        }

        private void addComments(){

            Comment []comments = new Comment[5];
            comments[0] = new Comment("comment 1");
            comments[1] = new Comment("comment 2");
            comments[2] = new Comment("comment 3");
            comments[3] = new Comment("comment 4");
            comments[4] = new Comment("comment 5");

            tracker.addComment(comments[0], tracker.getAll()[3].getClientId());
            tracker.addComment(comments[1], tracker.getAll()[3].getClientId());
            tracker.addComment(comments[2], tracker.getAll()[1].getClientId());
            tracker.addComment(comments[3], tracker.getAll()[0].getClientId());
            tracker.addComment(comments[4], tracker.getAll()[0].getClientId());

            System.out.println("                                       " +
                    " ______/Add comments/______");
            System.out.println();
            System.out.println("________* Look what I've done *________");
            System.out.println();
            for (Item trackerItems:
                    tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println("Client Id: " + trackerItems.getClientId()
                            + "   Client name: " + trackerItems.getName()
                            + "   Date add: " + myFormat.format(trackerItems.getDateAdd())
                            + "   Description: " + trackerItems.getDescription());
                    for (Comment comment :
                            trackerItems.getComments()) {
                        if (comment != null) {
                            System.out.println(" - " + comment.getComment());
                        }
                    }
                    System.out.println("*-*-*");
                }

            }
            System.out.println("                                       " +
                    " ______/*End of table*/______");
            System.out.println();
        }

        private void updateClient(){
            System.out.println("                                       " +
                    " ______/Update client by Id/______");
            String clientId = tracker.getAll()[2].getClientId();
            System.out.println();
            System.out.println("________* Look what I've done *________");
            System.out.println();
            String newName = "Mike";
            long newDate = date.getTime();
            String newDescription = "description 12";
            Item newItem = new Item(newName, newDate, newDescription);
            newItem.setClientId(clientId);
            tracker.rename(newItem);
            for (Item trackerItems:
                    tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println("Client Id: " + trackerItems.getClientId()
                            + "   Client name: " + trackerItems.getName()
                            + "   Date add: " + myFormat.format(trackerItems.getDateAdd())
                            + "   Description: " + trackerItems.getDescription());
                    System.out.println("*-*-*");
                }
            }
            System.out.println("                                       " +
                    " ______/*End of table*/______");
            System.out.println();

        }
}
