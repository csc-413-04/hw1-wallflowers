package simpleserver;

import java.util.List;

public class Response {
    private String status;
    private int entries;
    private List data;

    public Response(String status, int entries, List data) {
        this.status = status;
        this.entries = entries;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public int getEntries() {
        return entries;
    }

    public List getData() {
        return data;
    }
}
