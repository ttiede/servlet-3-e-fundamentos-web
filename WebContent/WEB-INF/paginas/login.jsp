<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<p>Usu�rio logado: 
			<c:out value="${sessionScope.usuarioLogado.getEmail()}" />
		</p>
	</body>
</html>