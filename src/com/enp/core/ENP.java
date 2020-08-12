package com.enp.core;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ENP
{

   public static boolean verifyNegativePassword(List<String> ndb1, String hash)
   {

      // int l = RCDriver.decryptString(ndb1.get(0), hash).length();
      int l = AES.decrypt(ndb1.get(0), hash).length();
      char[][] ndb = new char[ndb1.size()][l];

      int p = 0;
      for (String s : ndb1)
      {

         String sss = AES.decrypt(s, hash);
         char chArr[] = sss.toCharArray();
         for (int j = 0; j < chArr.length; j++)
         {
            ndb[p][j] = chArr[j];
         }
         p++;

      }

      hash = stringToBinary(hash);
      int m = hash.length();
      char x[] = new char[m];
      for (int i = 0; i < m; i++)
      {
         if (numberOfSP(ndb[i]) - 1 != i)
         {
            return false;
         }
      }
      Set<Integer> foundIndexes = new HashSet<>();
      for (int i = 0; i < m; i++)
      {

         int index = indexOfSP(ndb[i], foundIndexes);
         x[index] = ndb[i][index];

         for (int j = i + 1; j < m; j++)
         {
            ndb[j][index] = '*';
         }
      }

      String gen = new String(x);
      if (gen.equals(hash))
         return true;
      else
         return false;
   }

   public static int indexOfSP(char[] chArr, Set<Integer> foundIndexes)
   {
      int index = 0;

      for (int i = 0; i < chArr.length; i++)
      {
         if (chArr[i] != '*' && !foundIndexes.contains(i))
         {
            index = i;
         }
      }
      return index;
   }

   public static int numberOfSP(char[] chArr)
   {
      int count = 0;
      for (int i = 0; i < chArr.length; i++)
      {
         if (chArr[i] != '*')
         {
            count++;
         }
      }
      return count;
   }

   public static List<String> generateNegativePassword(String str)
   {
      String s = stringToBinary(str);

      char[][] ndb = new char[s.length()][s.length()];

      String permutedBits = randomPermutation(s);

      int m = permutedBits.length();
      for (int i = 0; i < m; i++)
      {
         char[] x = createSequenceOfSymbols(m);
         for (int j = 0; j < i; j++)
         {
            x[j] = permutedBits.charAt(j);
         }

         if (permutedBits.charAt(i) == '1')
            x[i] = '1';
         else
            x[i] = '0';

         for (int j = i + 1; j < m; j++)
         {
            x[j] = '*';
         }

         // System.out.println(x);
         x = invertPermutation(x, s, i + 1);
         // System.out.println(x);
         // System.out.println("----------------------------------------");
         ndb[i] = x;
      }

      List<String> result_ndb = new ArrayList<>();
      for (int i = 0; i < ndb.length; i++)
      {
         String ndb_string = new String(ndb[i]);
         result_ndb.add(AES.encrypt(ndb_string, str));
      }
      return result_ndb;
   }

   public static int getRandomWithExclusion(Random rnd, int start, int end, List<Integer> exclude)
   {
      int random = start + rnd.nextInt(end - start + 1 - exclude.size());
      for (int ex : exclude)
      {
         if (random < ex)
         {
            break;
         }
         random++;
      }
      return random;
   }

   public static char[] invertPermutation(char[] x, String s, int n)
   {
      char res[] = new char[s.length()];
      Set<Integer> indexCheck = new HashSet<>();
      List<Integer> randomList = new ArrayList<>();

      // if (s.length() == n)
      // return s.toCharArray();

      for (int i = 0; i < s.length(); i++)
      {
         randomList.add(i);
      }
      Collections.shuffle(randomList);
      int k = 0;

      for (int p = 0; p < res.length; p++)
      {
         res[p] = '*';
      }
      for (int j = 0; j < n; j++)
      {
         int index = -1;
         k = 0;

         while (true)
         {
            index = randomList.get(k++);
            if (k == s.length())
               k = 0;

            if (s.charAt(index) == x[j] && !indexCheck.contains(index))
            {
               indexCheck.add(index);
               break;
            }
         }
         res[index] = x[j];
      }

      return res;
   }

   public static char[] createSequenceOfSymbols(int m)
   {
      char chArr[] = new char[m];
      for (int i = 0; i < m; i++)
      {
         chArr[i] = '*';
      }
      return (chArr);
   }

   public static String randomPermutation(String str)
   {
      List<Character> list = new ArrayList<>();
      char chArr[] = str.toCharArray();
      for (int i = 0; i < chArr.length; i++)
      {
         list.add(chArr[i]);
      }
      Collections.shuffle(list);

      char[] chArr2 = new char[list.size()];
      int i = 0;
      for (char c : list)
      {
         chArr2[i++] = c;
      }
      return new String(chArr2);
   }

   public static char[] intArrayToCharArray(int intArr[])
   {
      char chArr[] = new char[intArr.length];
      for (int i = 0; i < intArr.length; i++)
      {
         char ele = (char) intArr[i];
         chArr[i] = ele;
      }
      return chArr;
   }

   public static int[] charArrayToIntArray(char chArr[])
   {
      int intArr[] = new int[chArr.length];
      for (int i = 0; i < chArr.length; i++)
      {
         int ele = (int) chArr[i];
         intArr[i] = ele;
      }
      return intArr;
   }

   public static String stringToBinary(String str)
   {
      StringBuilder sb = new StringBuilder();

      for (char character : str.toCharArray())
      {
         sb.append(Integer.toBinaryString(character));
      }

      return sb.toString();

   }

   public static String sha256(String str) throws NoSuchAlgorithmException
   {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

      return new String(hash);
   }
   
   

   public static void main(String args[]) throws NoSuchAlgorithmException
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Chose your password: ");
      String password = sc.nextLine();
      List<String> ndb = generateNegativePassword(sha256(password));
      System.out.println("Generated NDB : ");
      for (String s : ndb)
      {
         System.out.println(s);
      }

      System.out.print("\n\nEnter your password to verify: ");
      String password2 = sc.nextLine();
      try
      {
         boolean result = verifyNegativePassword(ndb, sha256(password2));
         if (result)
            System.out.println("Your password is CORRECT");
      }
      catch (Exception e)
      {
         System.out.println("Your password is INCORRECT");
      }
      sc.close();
   }

}
