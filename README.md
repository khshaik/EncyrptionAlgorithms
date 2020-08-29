# EncyrptionAlgorithms – MD5, SHA256, SHA512, PBKDF2, BCrypt, SCrypt, Kerberos, RSA, AES, DES, Digital Signatures, SSL Certificates.

Learn Java Secure Hashing algorithms in-depth. A secure password hash is an encrypted sequence of characters obtained after applying certain algorithms and manipulations on user-provided password, which are generally very weak and easy to guess.

There are many such hashing algorithms in Java which can prove really effective for password security.

Please remember that once this password hash is generated and stored in the database, you can not convert it back to the original password.

Each time user login into the application, you have to regenerate password hash again and match with the hash stored in the database. So, if the user forgot his/her password, you will have to send him a temporary password and ask him to change it with his new password. It’s common nowadays, right?

# MD5 algorithm
A widely used hash function producing a 128-bit hash value. Although MD5 was initially designed to be used as a cryptographic hash function, it has been found to suffer from extensive vulnerabilities. It can still be used as a checksum to verify data integrity, but only against unintentional corruption. It remains suitable for other non-cryptographic purposes, for example for determining partition for a particular key in a partitioned database.MD5 was designed by Ronald Rivest in 1991 to replace an earlier hash function MD4 and was specified in 1992 as RFC 1321.

One basic requirement of any cryptographic hash function is that it should be "computationally infeasible to find two distinct messages that hash to same value". MD5 fails this requirement catastrophically; such collisions can be found in seconds on an ordinary home computer. The weaknesses of MD5 have been exploited in the field, most infamously by Flame malware in 2012. The CMU Software Engineering Institute considers MD5 essentially "cryptographically broken and unsuitable for further use". As of 2019, MD5 continues to be widely used, in spite of its well-documented weaknesses and deprecation by security experts.

The MD5 Message-Digest Algorithm is a widely used cryptographic hash function that produces a 128-bit (16-byte) hash value. The basic idea is to map data sets of variable length to data sets of a fixed length. In order to do this, input message is split into chunks of 512-bit blocks. A padding is added to the end so that it’s length can be divided by 512. Now, these blocks are processed by MD5 algorithm, which operates in a 128-bit state, and result will be a 128-bit hash value. After applying MD5, generated hash is typically a 32-digit hexadecimal number. The password to be encoded is often called “message” and generated hash value is called "message digest" or simply “digest”. 

# Collision vulnerabilities
A collision attack exists that can find collisions within seconds on a computer with a 2.6 GHz Pentium 4 processor. In 1996, collisions were found in the compression function of MD5, researchers were able to create pairs of PostScript documents[35] and X.509 certificates[36] with the same hash. MD5 collisions to create an intermediate certificate authority certificate that appeared to be legitimate when checked by its MD5 hash. MD5 uses the Merkle–Damgård construction, so if two prefixes with the same hash can be constructed, a common suffix can be added to both to make the collision more likely to be accepted as valid data by the application using it. Furthermore, current collision-finding techniques allow to specify an arbitrary prefix: an attacker can create two colliding files that both begin with the same content. All the attacker needs to generate two colliding files is a template file with a 128-byte block of data, aligned on a 64-byte boundary that can be changed freely by the collision-finding algorithm.

Both produce the MD5 hash 79054025255fb1a26e4bc422aef54eb4.The difference between the two samples is that the leading bit in each nibble has been flipped. For example, the 20th byte (offset 0x13) in the top sample, 0x87, is 10000111 in binary. The leading bit in the byte (also the leading bit in the first nibble) is flipped to make 00000111, which is 0x07, as shown in the lower sample.

# Applications
MD5 digests have been widely used in the software world to provide some assurance that a transferred file has arrived intact. As it is easy to generate MD5 collisions, it is possible for the person who created the file to create a second file with the same checksum, so this technique cannot protect against some forms of malicious tampering.
