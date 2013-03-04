xquery version "1.0";
<listing>
{
for $art in
	doc("artist.xml")
//artist

for $alb in
	doc("album.xml")
//album

where
    $art/artistid = $alb/album_id	
	
return
	
	 <artistAlbum>
	{    
    ($art/artistname, $alb/albumName)
    }
    </artistAlbum>
	 
}
</listing>