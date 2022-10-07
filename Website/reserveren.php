<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="reserveren.css">
    <link rel="shortcut icon" href="..\Website\images\logopng.png"/> 
    <title>Holly Guacamoley Reserveren</title>
</head>
<body>
    <div></div>
<?php 
    include 'header.php'; 
?> 
<div class="black-header"></div>
<div class="front-image"></div>
<center>
    <p class="front-title">Reserveren</p>
    <p class="front-info">Kom je bij ons eten? Reserveer alvast je plaats!</p>
</center>

<p class="main-text-left">Gemakkelijk en snel reserveren</p>
<p class="phone-text-left">Plaatst u uw redservering het liefts telefonisch? <br> Dan kunt u ons bellen op: +31 6 00000000</p>

<form method="post">
    <div class="form-main">
        <input type="text" class="form-naam" name="name" placeholder="Naam" required>
        <input type="email" class="form-datum" name="datum" placeholder="Datum" required>
        <input type="text" class="form-leeftijd" name="leeftijd" placeholder="Aantal volwassenen - boven de 11 jaar" required>
        <input type="text" class="form-leeftijd-11" name="vragen" placeholder="Aantal kinderen - 11 jaar en jonger" required>
        <input type="submit" name="submit" class="submit">
    </div>
</form>

<?php 
    include 'footer.php'; 
?> 
</body>
</html>
    