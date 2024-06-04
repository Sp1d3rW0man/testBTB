import sqlite3

def get_user(username):
    conn = sqlite3.connect('example.db')
    cursor = conn.cursor()
    query = "SELECT * FROM users WHERE username = ?"
    cursor.execute(query, (username,))
    return cursor.fetchall()

# Simulate user input
user_input = "admin"
print(get_user(user_input))
