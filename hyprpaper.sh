#!/bin/bash
#SOURCE_DIR=/usr/share/backgrounds/RainAnime
SOURCE_DIR=/usr/share/backgrounds/girlAnime4k
MONITOR_NAME=eDP-1
INTERVAL=300

setPaper(){
	#get a array of all wallpapers from the SOURCE_DIR
	paperArray=(
		"$SOURCE_DIR"/*.jpg
		"$SOURCE_DIR"/*.png
#		"$SOURCE_DIR"/*.jpeg
	)


	#get a random wallpaper from source dir array
	paperToSet=$((0 + $RANDOM % ${#paperArray[@]}))

	#cleanup
	hyprctl hyprpaper unload all 

	#preload ad set:
	hyprctl hyprpaper preload ${paperArray[$paperToSet]} 
	hyprctl hyprpaper wallpaper "$MONITOR_NAME,${paperArray[$paperToSet]}" 
}

createArray(){
        #get a array of all wallpapers from the SOURCE_DIR
        paperArray=(
                "$SOURCE_DIR"/*.jpg
                "$SOURCE_DIR"/*.png
                "$SOURCE_DIR"/*.jpeg
        )
}

createArray

#check if hyprpaper daemon is running, else we cannot talk to the socket
#pgrep hyprpaper || hyprpaper &
if ! pgrep -x "hyprpaper" > /dev/null; then
#if ! pgrep -f hyprpaper > /dev/null 2>&1; then
	hyprpaper &
	sleep 0.1	
fi

while true; do
	setPaper
	hyprctl hyprpaper unload all 
	sleep "$INTERVAL"
done
