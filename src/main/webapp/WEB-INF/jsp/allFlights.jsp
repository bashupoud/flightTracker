<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Flights page</h1>

<ul>
<c:forEach items="${flights}" var="flight">
   <li><a href="<c:url value="/website/flights/flight/${flight.name}"/>">${flight}</a></li>
</c:forEach>
</ul>