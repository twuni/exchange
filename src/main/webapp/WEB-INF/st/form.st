<?xml version="1.0" encoding="UTF-8"?>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Exchange</title>
	</head>
	<body>

		<h1>Exchange</h1>

		<form method="post" action="buy">
			<fieldset>

				<legend>Buy a Token</legend>

				<div>
					<label for="buy_amount">Amount:</label>
					<input type="text" id="buy_amount" name="amount" value="" title="This is how much value the token you purchase will have."/>
				</div>

				<button type="submit">Buy</button>

			</fieldset>
		</form>

		<form method="post" action="sell">
			<fieldset>

				<legend>Sell a Token</legend>

				<div>
					<label for="sell_username">PayPal Username:</label>
					<input type="text" id="sell_username" name="username" value="" title="This is the username who will be paid."/>
				</div>

				<div>
					<label for="sell_token">Token:</label>
					<textarea id="sell_token" name="token"></textarea>
				</div>

				<button type="submit">Sell</button>

			</fieldset>
		</form>

	</body>
</html>
