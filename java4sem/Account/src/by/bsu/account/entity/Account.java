package by.bsu.account.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class Account implements Serializable, Cloneable{
    ArrayList<OperationInfo> operationInfo;

    public Account() {
        this.operationInfo = new ArrayList<>();
    }

    public void addOperation(long operationID, OperationType type, float sum) {
        this.operationInfo.add(new OperationInfo(operationID, type, sum));
    }

    public void addOperation(long operationID, OperationType type, ArrayList<LocalTime> localTimes,float sum) {
        this.operationInfo.add(new OperationInfo(operationID, type, sum, localTimes));
    }

    public ArrayList<OperationInfo> getOperationInfo() {
        return operationInfo;
    }

    public void setOperationInfo(ArrayList<OperationInfo> operationInfo) {
        this.operationInfo = operationInfo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Account copy = null;
        try {
            copy = (Account)super.clone();
            copy.operationInfo = (ArrayList<OperationInfo>)operationInfo.clone();
            for (int i = 0; i < copy.operationInfo.size(); i++) {
                OperationInfo o = copy.operationInfo.get(i);
                copy.operationInfo.set(i, (OperationInfo)o.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return copy;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Account account = (Account) obj;

        return Objects.equals(operationInfo, account.operationInfo);
    }

    @Override
    public int hashCode() {
        return operationInfo != null ? operationInfo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public class OperationInfo implements Serializable, Cloneable {
        long operationID;
        OperationType type;
        float sum;
        TreeSet<LocalTime> time;

        public OperationInfo(long operationID, OperationType type, float sum) {
            this.operationID = operationID;
            this.type = type;
            this.sum = sum;
            this.time = new TreeSet<>();
        }

        public OperationInfo(long operationID, OperationType type, float sum, ArrayList<LocalTime> time) {
            this.operationID = operationID;
            this.type = type;
            this.sum = sum;
            this.time = new TreeSet<>(time);
        }

        public long getOperationID() {
            return operationID;
        }

        public OperationType getType() {
            return type;
        }

        public double getSum() {
            return sum;
        }

        public TreeSet<LocalTime> getTime() {
            return time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OperationInfo that = (OperationInfo) o;

            return operationID == that.operationID &&
                    Double.compare(that.sum, sum) == 0 &&
                    type == that.type &&
                    Objects.equals(time, that.time);
        }

        @Override
        public int hashCode() {
            return Objects.hash(operationID, type, sum, time);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            OperationInfo copy = null;
            try {
                copy = (OperationInfo)super.clone();
                copy.time = (TreeSet<LocalTime>)time.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            return copy;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            Iterator itr = this.time.iterator();
            while (itr.hasNext()) {

                String beg = itr.next().toString();
                String end;
                if (itr.hasNext()) {
                    end = itr.next().toString();
                    res.append(beg + " - " + end + "\n");
                }

            }
            if (res.length() == 0) {
                res.append("no finished\n");
            }
            return "Operation {\n" +
                    "id = " + operationID + "\n" +
                    "type = " + type.toString() + "\n" +
                    "operation time: \n" + res.toString() +
                    "sum = " + sum +
                    "\n}";
        }
    }// end OperationInfo

    public static class PersonInfo {
        String name;
        String surname;
        int age;
        String personalKey;

        public PersonInfo(String name, String surname, int age, String personalKey) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.personalKey = personalKey;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPersonalKey() {
            return personalKey;
        }

        public void setPersonalKey(String personalKey) {
            this.personalKey = personalKey;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) return false;
            PersonInfo that = (PersonInfo) obj;

            return name.equals(that.name) &&
                    surname.equals(that.surname) &&
                    personalKey.equals(that.personalKey) &&
                    Double.compare(that.age, age) == 0;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            OperationInfo copy = null;
            try {
                copy = (OperationInfo)super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            return copy;
        }

        @Override
        public String toString() {
            return "Personal information {\n" +
                    "name = " + name + "\n" +
                    "surname = " + surname + "\n" +
                    "age \n" + age +
                    "personal key = " + personalKey +
                    "\n}";
        }
    } // end PersonalInfo
}
