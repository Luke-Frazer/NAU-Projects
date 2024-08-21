# Authors: Luke Frazer and Brock Heinz


def main():

    sample = """
#######
#######
#######
#######
#######
"""
    a = """
   A   
  A A  
 AAAAA 
A     A
A     A
"""
    b = """
BBBBB  
B    B 
BBBBB  
B    B 
BBBBB  
"""
    c = """
  CCCC 
CC     
C      
CC     
  CCCC 
"""
    d = """
DDDDD  
D    D 
D    D 
D    D 
DDDDD  
"""
    e = """
EEEEEE 
E      
EEEEEE 
E      
EEEEEE 
"""
    f = """
FFFFFF 
F      
FFFFFF 
F      
F      
"""
    g = """
 GGGG  
G      
G  GGG 
G    G 
 GGGG  
"""
    h = """
H     H
H     H
HHHHHHH
H     H
H     H
"""
    i = """
IIIIIII
   I   
   I   
   I   
IIIIIII
"""
    j = """
JJJJJJJ
   J   
   J   
J  J   
 JJ    
"""
    k = """
K   KK 
K KK   
KK     
K KK   
K   KK 
"""
    l = """
L      
L      
L      
L      
LLLLLL 
"""
    m = """
M    M 
MM  MM 
M MM M 
M MM M 
M    M 
"""
    n = """
N   N  
NN  N  
N N N  
N  NN  
N   N  
"""
    o = """
 OOOO  
O    O 
O    O 
O    O 
 OOOO  
"""
    p = """
PPPPP  
P    P 
PPPPP  
P      
P      
"""
    q = """
 QQQQ  
Q    Q 
Q    Q 
 QQQQ  
     Q 
"""
    r = """
RRRRR  
R    R 
RRRRR  
R    R 
R    R 
"""
    s = """
 SSSS  
S      
 SSSS  
     S 
 SSSS  
"""
    t = """
TTTTTTT
   T   
   T   
   T   
   T   
"""
    u = """
U     U
U     U
U     U
 U   U 
  UUU  
"""
    v = """
V     V
V     V
 V   V 
  V V  
   V   
"""
    w = """
W  W  W
W W W W
W W W W
 W   W 
  W W  
"""
    x = """
X   X  
 X X   
  X    
 X X   
X   X  
"""
    y = """
Y     Y
 Y   Y 
  Y Y  
   Y   
   Y   
"""
    z = """
ZZZZZ  
   Z   
  Z    
 Z     
ZZZZZ  
"""
    space = """
       
       
       
       
       
       
"""
    letters = {
        'a': a,
        'b': b,
        'c': c,
        'd': d,
        'e': e,
        'f': f,
        'g': g,
        'h': h,
        'i': i,
        'j': j,
        'k': k,
        'l': l,
        'm': m,
        'n': n,
        'o': o,
        'p': p,
        'q': q,
        'r': r,
        's': s,
        't': t,
        'u': u,
        'v': v,
        'w': w,
        'x': x,
        'y': y,
        'z': z,
        ' ': space
    }

    check_string = input('Please enter a word: ')
    check_print = input('Would you like it vertical [1] or horizontal [2] ')
    if check_print == '1':
        printVertical(check_string, letters)
    elif check_print == '2':
        printHorizontal(check_string, letters)
    else:
        print('Error: Invalid choice')
        return None


def printHorizontal(string, letters):
    string = string.lower()
    for row in range(5):
        for char in string:
            print(letters.get(char, "ERROR")[(8 * row) + 1:(8 * (row + 1))] +
                  "  ",
                  end='')
        print("\n")


def printVertical(string, letters):
    string = string.lower()
    for char in string:
        print(letters.get(char, "ERROR"))


if __name__ == '__main__':
    main()
