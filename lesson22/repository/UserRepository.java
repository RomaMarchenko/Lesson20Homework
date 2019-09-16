package lesson22.repository;


import lesson22.repository.exception.BadRequestException;
import lesson22.repository.exception.InternalServelException;
import lesson22.repository.exception.UserNotFoundException;

public class UserRepository {
    private static User[] users = new User[10];

    public UserRepository() {
    }

    public UserRepository(User[] users) {
        this.users = users;
    }

    public static User[] getUsers() {
        return users;
    }

    private static int countUsers() {
        int countUsers = 0;
        for (User user : users) {
            if (user != null)
                countUsers++;
        }
        return countUsers;
    }

    public static String[] getUserNames() {
        int index = 0;
        String[] names = new String[countUsers()];
        for (User user : users) {
            if (user != null) {
                names[index] = user.getName()   ;
                index++;
            }

        }
        return names;
    }


    public static long[] getUserIds() {
        int index = 0;
        long[] ids = new long[countUsers()];
        for (User user : users) {
            if (user != null) {
                ids[index] = user.getId();
                index++;
            }

        }
        return ids;
    }

    public static String getUserNameById(long id) {
        String userName = null;
        for (User user : users) {
            if (user != null) {
                long userID = user.getId();
                if (userID == id) {
                    userName = user.getName();
                }
            }
        }
        return userName;
    }

    public static User getUserByName(String name) {
        User wantedUser = null;
        for (User user : users) {
            if (user != null) {
                String userName = user.getName();
                if (userName == name) {
                    wantedUser = user;
                    break;
                }
            }
        }
        return wantedUser;
    }

    public static User getUserById(long id) {
        User wantedUser = null;
        for (User user : users) {
            if (user != null) {
                long userId = user.getId();
                if (userId == id) {
                    wantedUser = user;
                    break;
                }
            }
        }
        return wantedUser;
    }

    public static User getUserBySessionId(String sessionId) {
        User wantedUser = null;
        for (User user : users) {
            if (user != null) {
                String userSessionId = user.getSessionId();
                if (userSessionId == sessionId) {
                    wantedUser = user;
                    break;
                }
            }
        }
        return wantedUser;
    }

    public static User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }

        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public static User save(User user) throws Exception{
        if(user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " is already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        int index = 0;
        for (User nullUser : users) {
            if (nullUser == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }

        throw new InternalServelException("Not enough space so save user with id: " + user.getId());
    }

    public static User update(User user) throws Exception {
        if(user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());

        int index = 0;
        for (User wantedUser : users) {
            if (wantedUser != null && wantedUser.getId() == user.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }

        throw new InternalServelException("Unexpected error");
    }

        public static void delete (long id) throws Exception {
            findById(id);

            int index = 0;
            for (User wantedUser : users) {
                if (wantedUser.getId() == id) {
                    users[index] = null;
                }
                index++;
            }
        }
}