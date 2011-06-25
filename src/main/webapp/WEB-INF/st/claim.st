<html>
	<head>
		<title>Claim</title>
	</head>
	<body>
		<h1>Claim.</h1>
		$context.errors:{error|<div class="error">$error$</div>}$
		$if(context.payment)$<div>$context.payment.token:{token|{id:"$token.id$",secret:"$token.secret$",treasury:"$token.treasury$",value:$token.value$}}$</div>$endif$
	</body>
</html>
