<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1>Game History</h1>
	<c:if test="${history != null }">
		<table border="1">
			<thead>
				<tr>
					<td>Attempt</td>
					<td>Guess</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${history}" var="item">
					<tr>
						<td>${item.key}</td>
						<td>${item.value}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>