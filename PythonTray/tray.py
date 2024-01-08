#!/usr/bin/python
#gi.require_version('Gtk', '4.0')

import gi
gi.require_version('Gtk', '3.0')


import os
import time
#gi.require_version('Gtk', '3.0')
from gi.repository import Gtk as gtk, AppIndicator3 as appindicator
#from gi.repository import Gtk as gtk, AppIndicator3 as appindicator

home_dir = os.environ['HOME']
clientConf = home_dir + "/.config/pulse/client.conf"
clientConfLocal = home_dir + "/.config/pulse/client.conf.local"
clientConfNuccy = home_dir + "/.config/pulse/client.conf.nuccy"
clientConfLenovo = home_dir + "/.config/pulse/client.conf.lenovo"
pulseSwitcher = home_dir + "/.config/pulse/pulseSwitcher.sh"

indicator = appindicator.Indicator.new("customtray", "/home/joris/.config/pulse/networked.svg", appindicator.IndicatorCategory.APPLICATION_STATUS)

def main():
  funcSetLoc()
  setNewIcon()
  indicator.set_status(appindicator.IndicatorStatus.ACTIVE)
  indicator.set_menu(menu())
  gtk.main()

def menu():
  menu = gtk.Menu()
  
  command_one = gtk.MenuItem('SwitchAudio')
  command_one.connect('activate', switch)
  menu.append(command_one)

  exittray = gtk.MenuItem('Exit Tray')
  exittray.connect('activate', quit)
  menu.append(exittray)
  
  menu.show_all()
  return menu

def setNewIcon():
  time.sleep(0.1)
  with open(clientConf) as f:
    if '172.16.141.40' in f.read():
      print('networked setting icon')
      indicator.set_icon("/home/joris/.config/pulse/networked.svg")
    else:
      print("local, setting icon")
      indicator.set_icon("/home/joris/.config/pulse/local.svg")
    f.close()
 
def funcSetLoc():
  print("setting audio to local playback")
  os.popen('cp ' + clientConfLocal + " " + clientConf)
  os.popen('systemctl --user stop pulseaudio')
  os.popen('systemctl --user start pulseaudio')

def funcSetNet():
  print("setting audio to networked playback")
  os.popen('cp ' + clientConfNuccy + " " + clientConf)
  os.popen('systemctl --user stop pulseaudio')
  os.popen('systemctl --user start pulseadio')
 
def switch(_):
  with open(clientConf) as f:
    if '172.16.141.40' in f.read():
      print('networked, switching to local')
      if os.path.exists(clientConf):
        os.remove(clientConf)
        funcSetLoc()
    else:
      print("local, switching to Networked")
      if os.path.exists(clientConf):
        os.remove(clientConf)
        funcSetNet()

      indicator.set_icon("/home/joris/.config/pulse/local.svg")
      f.close()

#  os.system(pulseSwitcher)
  setNewIcon()

def quit(_):
  gtk.main_quit()

if __name__ == "__main__":
  main()
