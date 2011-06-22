<?xml version="1.0" encoding="UTF-8"?>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Exchange</title>
	</head>
	<body>

		<h1>Exchange</h1>

		<form method="post" action="from/paypal">
			<fieldset>

				<legend>Buy a Token</legend>

				<div>
					<label for="from-paypal_amount">Amount:</label>
					<input type="text" id="from-paypal_amount" name="amount" value="" title="This is how much value the token you purchase will have."/>
				</div>

				<button type="submit">Buy</button>

			</fieldset>
		</form>

		<form method="post" action="to/paypal">
			<fieldset>

				<legend>Sell a Token</legend>

				<div>
					<label for="to-paypal_username">PayPal Username:</label>
					<input type="text" id="to-paypal_username" name="username" value="" title="This is the username who will be paid."/>
				</div>

				<div>
					<label for="to-paypal_token">Token:</label>
					<textarea id="to-paypal_token" name="token"></textarea>
				</div>

				<button type="submit">Sell</button>

			</fieldset>
		</form>

	</body>
</html>
