<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<form action="game" method="post">
		Enter your guess <input type="text" name="guess"><br/>
		<input type="submit" value="Guess"><br/>
		<c:if test="${guessingGame != null}">
			<h2>${guessingGame.message}</h2>
			<h3>Attempts: ${guessingGame.attempts}</h3>
		</c:if>
		<c:if test="${gameOver != null}">
				<script>
					var playAgain = 
						window.confirm("Do you want to play again?");
					if(!playAgain){
						window.location = "history.jsp";						
					}
				</script>
			</c:if>
	</form>
</body>
</html>