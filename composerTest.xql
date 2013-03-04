xquery version "1.0";
for $comp in
	doc("composer.xml")
//composer

return($comp/composerName)