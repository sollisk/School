# Solomon Lisk
# Artificial Intelligence Spring 2020
import math

class UAEmployee:

    def __init__(self, id, last_name, first_name):
        self.id = id
        self.first_name = first_name
        self.last_name = last_name

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id

    def get_first_name(self):
        return self.first_name

    def set_first_name(self, first_name):
        self.first_name = first_name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def hash_code(self, id):
        return self.id % 5

    def __str__(self):
        return "ID: \t" + self.get_id().__str__() + "\tName: " + self.first_name + "," + self.last_name


class UA_hash_map:

    def __init__(self, size):
        self.hash_map_size = size
        self.collision_count = 0
        self.fill_size = 0
        self.hash_table = [None] * size  # "Array" of UAEmployee Objects

    def hash_code(self, id):
        return (id % 5) % self.hash_map_size

    def hash_code_2(self, id):
        return (id % 17) % self.hash_map_size

    def size(self):
        return self.hash_map_size

    def get_collision_count(self):
        return self.collision_count

    def insert(self, k):
        id = k.get_id()
        hash = self.hash_code(id)
        hash2 = self.hash_code_2(id)
        i = 0
        while self.hash_table[hash] is not None:
            hash = hash + hash2 + i
            hash %= self.hash_map_size
            self.collision_count += 1
            i += 1
        self.hash_table[hash] = k
        self.fill_size += 1

    def search(self, id):
        hash = self.hash_code(id)

        while self.hash_table[hash] is not None:
            if self.hash_table[hash].get_id() == id:
                return self.hash_table[hash]
            hash = hash + self.hash_code_2(id)
            hash = hash % self.hash_map_size
        return "No matching ID"

    def read_file(self, filename):
        file1 = open(filename, "r")
        for line in file1:
            e = line.replace("\n", "").split(",")
            employee = UAEmployee(int(e[0]), e[1], e[2])
            if self.fill_size > (self.hash_map_size//2):
                self.resize()
            self.insert(employee)

    def resize(self):
        old_table = self.hash_table
        self.hash_map_size = self.hash_map_size * 2
        self.__init__(self.hash_map_size)
        self.hash_table = [None] * self.hash_map_size
        for emp in old_table:
            if emp is not None:
                self.insert(emp)

def main():
    map = UA_hash_map(10)
    map.read_file("input.txt")
    print(map.get_collision_count())

    for i in map.hash_table:
        if i is not None:
            print(i)
        else:
            print("Empty")

main()
