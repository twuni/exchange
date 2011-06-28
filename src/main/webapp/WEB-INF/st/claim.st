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
		$if(context.payment)$$context.payment.token:{token|
			<div class="token">{id:"$token.id$",secret:"$token.secret$",treasury:"$token.treasury$",value:$token.value$}</div>
			<script type="text/javascript" src="/js/lib/jquery-1.5.min.js"></script>
			<script type="text/javascript" src="/js/lib/jquery.qrcode.min.js"></script>
			<script type="text/javascript">/*<![CDATA[*/if(window.jQuery){jQuery(function(){jQuery(".token").append(jQuery("<div>").css({margin:"30px"}).qrcode({typeNumber:9,correctLevel:0,text:jQuery(".token").text()}));});}/*]]>*/</script>
		}$$endif$
	</body>
</html>
