<!doctype html>
<html lang="eng">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="contact.css">
    <link rel="shortcut icon" href="..\Website\images\logopng.png"/> 
    <title>Holly Guacamoley Contact</title>
</head>


<body>
<?php
    include 'header.php'; 
?> 
<div class="overlay"></div>
<div class="black-header"></div>
<div class="background-image"><img src="images/contacthead.png"></div>
<center><div class="main-text">Vragen? Wij helpen graag!</div></center>
<center><div class="text1">HOLLY GUACAMOLEY</div></center>
<center><div class="text2">De lekkerste tapas en drankjes haal je bij ons!</div></center>

<div class="linker-text">
    <p class="openingstijden">Openingstijden</p>
    <p class="straat">Henri Dunanstraat 40, 5807 ES Oostrum</p>
    <p class="telefoonnummer">Telefoonnummer</p>
    <a class="phone" href="tel:+31600000000"><u>31 6 00000000</u></a>
    <p class="kleine-info">Wij zijn 7 dagen per week open!<br> Maandag t/m zondag vanaf 17:00 uur tot 00:00 uur<br>(Keuken is gesloten vanaf 22:00 uur behalve desserts en dranken).</p>
    <p class="bij-holly">Bij Holly Guacamoley</p>
    <ul class="lists">
        <li class="list">Is pinnen mogelijk</li>
        <li class="list">Kun je gratis parkeren</li>
        <li class="list">Kun je dineren</li>
        <li class="list">Heb je een uitgebreide keuze</li>
        <li class="list">Kun je eten en drinken met je hele gezin</li>
    </ul>
</div>

<div class="rechter-text">
<form method="post">
    <div class="form-main">
        <input type="text" class="form-naam" name="name" placeholder="Naam" required>
        <input type="email" class="form-datum" name="email" placeholder="Email" required>
        <input type="text" class="form-leeftijd" name="onderwerp" placeholder="Onderwerp" required>
        <input type="text" class="form-leeftijd-11" name="vragen" placeholder="Vragen en opmerkingen" required>
        <input type="submit" name="submit" class="submit">
    </div>
</form>
</div>

<?php
    include 'footer.php'; 
?>

</body>
</html>
    