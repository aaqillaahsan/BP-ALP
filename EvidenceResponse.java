public class EvidenceResponse {
    private String name;
    private String response;

    public EvidenceResponse(String name, String response){
        this.name = name;
        this.response = response;
    }

    public String getName(){
        return name;
    }

    public String getResponse(){
        return response;
    }
}
