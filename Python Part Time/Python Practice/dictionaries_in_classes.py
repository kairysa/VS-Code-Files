class Player:
    player_details = []
    def __init__(self, player={}):
        self.name = player["name"]
        self.age = player["age"]
        self.position = player["position"]
        self.team = player["team"]
        self.player_details.append(self)
    
    @classmethod
    def player_info(cls):
        for info in cls.player_details:
            print(info.name)
            print(info.age)
            print(info.position)
            print(info.team)


kevin = {"name": "Kevin Durant", "age":34, "position": "small forward", "team": "Brooklyn Nets"}

# Uncomment the line below to test
player_kevin = Player(kevin)

player_kevin.player_info()