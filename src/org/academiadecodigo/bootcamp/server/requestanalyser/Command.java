package org.academiadecodigo.bootcamp.server.requestanalyser;


public enum Command {
    LOGIN(new LoginRequest()),
    GETDATA(new GetDataRequest()),
    GETPROFILE(new GetProfileRequest()),
    GETUSERLIST(new GetUserList()),
    POSTDATA(new PostDataRequest()),
    CREATEPROFILE(new NewProfileRequest()),
    QUIT(new QuitRequest()),
    ERROR(new Error());


    private RequestAnalyser analyser;

    Command (RequestAnalyser analyser) {
        this.analyser = analyser;
    }

    public static Command getRequestType(String request) {

        String[] requestHandler = request.split("::");
        System.out.println(requestHandler[0]);

        if(requestHandler[0].equals("list")) {
            return GETUSERLIST;
        }

        if(requestHandler[0].equals("getProfile")) {
            return GETPROFILE;
        }

        if (requestHandler[0].equals("quit")){
            return QUIT;
        }

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

    public RequestAnalyser getAnalyser() {
        return this.analyser;
    }
}
