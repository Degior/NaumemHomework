package org.example;

import java.util.*;

public class User implements Comparable<User> {
    private String username;
    private String email;
    private byte[] passwordHash;

    public User(String username, String email, byte[] passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(username, user.username) && Objects.equals(email, user.email) && Arrays.equals(passwordHash, user.passwordHash);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username, email);
        result = 31 * result + Arrays.hashCode(passwordHash);
        return result;
    }

    public String toString() {
        return "User(" + username + ", " + email + ")";
    }


    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        List<User> duplicates = new ArrayList<>();
        Set<User> set = new HashSet<>(collB);
        for (User a : collA) {
            if (set.contains(a)) {
                duplicates.add(a);
            }
        }
        return duplicates;
    }


    @Override
    public int compareTo(User o) {
        return this.username.compareTo(o.username);
    }
}
