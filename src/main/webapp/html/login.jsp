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
    <label style="margin: 5px 15px 5px 20px;">First Name</label>
    <input style="margin: 5px 15px 5px 20px;" name="fname" type="text" id="fname" placeholder=""/></br>
    <label style="margin: 5px 15px 5px 20px;">Last Name</label>
    <input style="margin: 5px 15px 5px 20px;" name="lname" type="text" id="lname" placeholder=""/></br>
    <input style="margin: 5px 20px 5px 20px;" type="submit" value="Submit" id="submit"/>
</form>

<ol><h3><em>Favourite Programming Languages as of <%=displayDate() %>
</em></h3>
    <%
        String[] pls = (String[]) request.getAttribute("pls");
        for (String i : pls) { %>
    <li><%=i%>
    </li>
    <% } %>
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