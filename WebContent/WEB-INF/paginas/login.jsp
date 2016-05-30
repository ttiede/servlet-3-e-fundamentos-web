<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<p>Usuário logado: 
			<c:out value="${sessionScope.usuarioLogado.getEmail()}" />
		</p>
	</body>
</html>