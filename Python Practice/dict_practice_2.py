# List of dictionaries
users = [
    {"first": "Ada", "last": "Lovelace"}, # index 0
    {"first": "Alan", "last": "Turing"}, # index 1
    {"first": "Eric", "last": "Idle"} # index 2
]
# Dictionary of lists
resume_data = {
    #        	     0           1           2
    "skills": ["front-end", "back-end", "database"],
    #                0           1
    "languages": ["Python", "JavaScript"],
    #                0              1
    "hobbies":["rock climbing", "knitting"]
}

print(resume_data["skills"][0])

resumes = [
    {
        "skills": ["front-end", "back-end", "database"],
        "languages": ["Python", "JavaScript"],
        "hobbies":["rock climbing", "knitting"]
    },
    {
        "skills": ["front-end", "back-end", "database"],
        "languages": ["Python", "JavaScript"],
        "hobbies":["rock climbing", "knitting"]
    },
    {
        "skills": ["front-end", "back-end", "database"],
        "languages": ["Python", "JavaScript"],
        "hobbies":["rock climbing", "knitting"]
    },
]

print(resumes[0]["languages"][1])