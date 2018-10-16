package simpleserver;

public abstract class Response {
    boolean success; // status
    String id;

    public int entries;
    public String status;

    public void setStatus(String status){
        this.status = status;
    }


    public abstract String response();


}