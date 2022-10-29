drawers = ["documents", "envelopes", "pens"]
print(drawers[0])
drawers[0] = "clothes"
print(drawers[0])

nums = [1,2,3,4,5,6]
nums.append(82)
print(nums)

words = ["start","going","till","the","end"]
print(words[1:])
print(words[:4])
print(words[2:4])

# Making a copy of a list
copy_of_words = words[:]
copy_of_words.append("dojo") # only appends to the copy
print(copy_of_words) # prints ['start', 'going', 'till', 'the', 'end', 'dojo']
print(words) # prints ['start', 'going', 'till', 'the', 'end']