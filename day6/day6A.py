from sys import argv
script, filename = argv

lights = [[0 for i in range(1000)] for j in range(1000)]
turned_on = 0

def turn_on(coordinates):
	start_x = coordinates[0]
	start_y = coordinates[1]
	end_x = coordinates[2] + 1
	end_y = coordinates[3] + 1
	global turned_on
	global lights
	while start_x < end_x:
		y = start_y
		while y < end_y:
			if not lights[start_x][y] == 1 :
				lights[start_x][y] = 1
				turned_on=turned_on+1
			y=y+1
		start_x=start_x+1


def turn_off(coordinates):
	start_x = coordinates[0]
	start_y = coordinates[1]
	end_x = coordinates[2] + 1
	end_y = coordinates[3] + 1
	global turned_on
	global lights
	while start_x < end_x:
		y = start_y
		while y <  end_y:
			if not lights[start_x][y] == 0 :
				lights[start_x][y] = 0
				turned_on=turned_on-1
			y=y+1
		start_x=start_x+1

def toggle(coordinates):
	start_x = coordinates[0]
	start_y = coordinates[1]
	end_x = coordinates[2] + 1
	end_y = coordinates[3] + 1
	global turned_on
	global lights
	while start_x < end_x:
		y = start_y
		while y <  end_y:
			if lights[start_x][y] == 0 :
				lights[start_x][y] = 1
				turned_on = turned_on+1
			else:
				lights[start_x][y] = 0
				turned_on = turned_on-1
			y = y+1
		start_x = start_x+1

with open(filename) as f:
	for line in f:
		line = line.replace(',', ' ')
		coordinates = [int(s) for s in line.split() if s.isdigit()]
		if "turn on" in line:
			turn_on(coordinates);
		elif "turn off" in line:
			turn_off(coordinates);
		elif "toggle" in line:
			toggle(coordinates);
print "There are",turned_on,"lights turned on."
