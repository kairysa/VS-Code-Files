class playerList:
    new_team = []
    def __init__(self, player={}):
        self.name = player["name"]
        self.age = player["age"]
        self.position = player["position"]
        self.team = player ["team"]
        self.new_team.append(self)

    def player_info(self):
        print(self.name)
        print(self.age)
        print(self.position)
        print(self.team)
        return self
    
    @classmethod
    def player_list(cls):
        for info in cls.new_team:
            print(info.name)
            print(info.age)
            print(info.position)
            print(info.team)

kevin = {
    "name": "Kevin Durant", 
    "age":34, 
    "position": "small forward", 
    "team": "Brooklyn Nets"
    }
jason = {
    "name": "Jason Tatum", 
    "age":24, 
    "position": "small forward", 
    "team": "Boston Celtics"
    }
kyrie = {
    "name": "Kyrie Irving", 
    "age":32, "position": "Point Guard", 
    "team": "Brooklyn Nets"
    }
damian = {
    "name": "Damian Lillard", 
    "age":33, "position": "Point Guard", 
    "team": "Portland Trailblazers"
    }
joel = {
    "name": "Joel Embiid", 
    "age":32, "position": "Power Foward", 
    "team": "Philidelphia 76ers"
    }

player_kevin = playerList(kevin)
player_jason = playerList(jason)
player_kyrie = playerList(kyrie)
player_damian = playerList(damian)
player_joel = playerList(joel)

playerList.player_list()