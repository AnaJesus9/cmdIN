package org.academiadecodigo.bootcamp.server.requestAnalyze;


public enum Command {
    LOGIN(new LoginRequest()),
    GETDATA(new GetDataRequest()),
    POSTDATA(new PostDataRequest()),
    CREATEPROFILE(new NewProfileRequest()),
    QUIT(new QuitAnalyzer()),
    ERROR(new Error());


    private RequestAnalyzer analyzer;

    Command (RequestAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public static Command getRequestType(String request) {

        String[] requestHandler = request.split(" ");

        if(requestHandler[0].equals("login")) {
            return LOGIN;
        }

        if (requestHandler[0].equals("get")) {
            return GETDATA;
        }

        if(requestHandler[0].equals("post")) {
            return POSTDATA;
        }

        if (requestHandler[0].equals("create")) {
            return CREATEPROFILE;
        }


        return ERROR;

    }

    public RequestAnalyzer getAnalyzer() {
        return this.analyzer;
    }
}
