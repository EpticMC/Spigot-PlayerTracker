# Spigot-PlayerTracker

This plugin allows you to track every command of a specific player

Usage:

| Command | Explanation |
|---------|-------------|
| `/track <player>` | Starts/Stops tracking a player     |
| `/tc <player>`    | Same as above (alias for `/track`) |

Config Overview:

```YAML

##############################
#----------------------------#
# Copyright (c) 2017 NullDev #
#--- The Eptic MC Project ---#
#----------------------------#
##############################
#
# Informnations (README):
#
# === Plugin ===
#
# Name: PlayerTracker
# Description: Track all commands of a specific player
# Version: 1.0.0
#
# === Formatting ===
# 
# You can use Normal Minecraft Formatting Codes by using the prefix '&'
# --> See here: http://minecraft.gamepedia.com/Formatting_codes
#
# You can also cerate new lines by using '\n'
#
# === Placeholder ===
#
# The plugin replaces %player% with the playername and %command% with the command executed by the player
# They can be used anywhere in the messages.
#
##############################

############
#----------#
# MESSAGES #
#----------#
############
#
# Info:
# You can specify the plugin messages here
#
############

on_command: "&c%player% &aused the command &c%command%&a."
enable_tracker: "&aYou are now tracking &c%player%&a's commands."
disable_tracker: "&aYou are no longer tracking &c%player%&a's commands."
player_not_existant: "&aThis player does not exist."
player_offline: "&aThis player is not online."
specify_name: "&aPlease enter a players name."

###############
#-------------#
# CHAT PREFIX #
#-------------#
###############
#
# Info:
# This is the prefix for each plugin message in the chat
#
###############

prefix: "&0&l[&c&lTracker&0&l]&r "
enable_prefix: true

###################
#-----------------#
# IGNORE COMMANDS #
#-----------------#
###################
#
# Info:
# Seperate with ','
# Example: ignore_commands: "command1, command2, command3"
#
###################

ignore_commands: ""

```
