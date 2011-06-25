<html>
	<head>
		<title>Claim</title>
		<style type="test/css">
			html { background-color: #FFF; color: #000; }
			.error { font-weight: bold; color: #900; }
		</style>
	</head>
	<body>
		<h1>Claim.</h1>
		$context.errors:{error|<div class="error">$error$</div>}$
		$if(context.payment)$<div>$context.payment.token:{token|{id:"$token.id$",secret:"$token.secret$",treasury:"$token.treasury$",value:$token.value$}}$</div>$endif$
	</body>
</html>
