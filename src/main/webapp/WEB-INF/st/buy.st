<html>
	<head>
		<title>Buy</title>
	</head>
	<body>

		<h1>Buy.</h1>
		$context.errors:{error|<div>$error$</div>}$

		<div>

			<form method="post" action="pay">

				<div>
					<label>Card Number:</label>
					<input type="text" name="accountNumber" value=""/>
				</div>

				<div>
					<label>Expiration Date:</label>
					<input type="text" name="expirationDate" value=""/>
				</div>

				<div>
					<label>Amount:</label>
					<input type="text" name="amount" value="$context.amount$"/>
				</div>

				<button type="submit">Pay</button>

			</form>

		</div>

	</body>
</html>
