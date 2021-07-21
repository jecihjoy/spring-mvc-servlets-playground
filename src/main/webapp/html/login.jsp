<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forwarding in practice</title>
</head>
<body>
<%@include file="header.jsp" %>
<form method="post">
    <label style="margin: 5px 15px 5px 20px;">Username</label>
    <input style="margin: 5px 15px 5px 20px;" name="username" type="text" id="username" placeholder=""/></br>
    <label style="margin: 5px 15px 5px 20px;">Password</label>
    <input style="margin: 5px 15px 5px 20px;" name="password" type="text" id="password" placeholder=""/></br>
    <input style="margin: 5px 20px 5px 20px;" type="submit" value="Login" id="login"/>
    <!--SESSION MANAGEMENT WITH URL REWRITING-->
    <a href="<%=response.encodeURL("hello-servlet")%>">Home</a>
</form>

<ol><h3><em>Favourite Programming Languages as of <%=displayDate() %>
</em></h3>
    <%
        String[] pls = (String[]) request.getAttribute("pls");
        if (pls.length > 0) {
            for (String i : pls) { %>
    <li><%=i%>;
    </li>
    <% }
        ;
    }
        ;%>
</ol>

<ol>
    <h3><em>Add Other Programming Languages</em></h3>
    <form method="get">
        <input style="margin: 5px 15px 5px 20px;" name="pl" type="text" id="pl" placeholder=""/></br>
        <input style="margin: 5px 20px 5px 20px; background-color: #008CBA; padding: 8px 32px;" type="submit"
               value="Add" id="save"/>
    </form>
    <%
        List<String> otherPls = (ArrayList) session.getAttribute("otherPls");
        if (!otherPls.isEmpty()) {
            for (String i : otherPls) { %>
    <li><%=i%>
    </li>

    <% }
    } %>
</ol>

<%!
    public String displayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm");
        Date date = Calendar.getInstance().getTime();
        return dateFormat.format(date);
    }

%>
</body>
</html>