<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forwarding in practice</title>
</head>
<body>
<form method="post">
  <label style="margin: 5px 15px 5px 20px;">First Name</label>
  <input style="margin: 5px 15px 5px 20px;" name="fname" type="text" id="fname" placeholder=""/></br>
  <label style="margin: 5px 15px 5px 20px;">Last Name</label>
  <input style="margin: 5px 15px 5px 20px;" name="lname" type="text" id="lname" placeholder=""/></br>
  <input style="margin: 5px 20px 5px 20px;" type="submit" value="Submit" id="submit"/>
</form>

<ol><h3><em>Favourite Programming Languages as of <%=displayDate() %></em></h3>
    <%
        String[] pl = (String[]) request.getAttribute("pl");
        for(String i: pl) { %>
    <li><%=i%></li>
    <% } %>
</ol>

<%!
    public String displayDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm");
        Date date = Calendar.getInstance().getTime();
        return dateFormat.format(date);
    }

%>
</body>
</html>