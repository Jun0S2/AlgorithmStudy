/**
Queue
4/14/2022
*/
#include <iostream>

using namespace std;

struct Queue {
  int data[1001];
  int frontPointer,rearPointer;
  int capacity;
  int numElement;
  
  void create(int y){
    capacity = y; // maxCap
    frontPointer = 0;
    rearPointer = 0;
    numElement = 0; //currSize
  }
  
  void push(int y){
    if(numElement >= capacity) cout<<"Overflow"<<endl;
    else
    {
      data[rearPointer++] = y;
      numElement ++;
      if(rearPointer==capacity)rearPointer = 0;
    }
  }
  
  void  pop(){
    if(numElement == 0)cout<<"Underflow"<<endl;
    else
    {
      data[frontPointer++]=0;
      numElement--;
      if(frontPointer==capacity)frontPointer = 0;
    }
  }
  
  void front(){
    if(numElement == 0 )cout<<"NULL"<<endl;
    else cout<<data[frontPointer]<<endl;
  }
  
  int size() {return numElement;}
};

int main() {
  Queue q1;
  int N,M,op=0,val = 0;
  cin >>N>>M;
  //create queue size of N  
  q1.create(N);

  for(int i = 0 ; i<M ; i++)
  {
    cin>>op;
    if(op==1)//push
    {
      cin>>val;
      q1.push(val);
    }
    else if (op==2) //pop 
    {
      q1.pop();
    }
    else if(op==3) //front 
    {
      q1.front();
    }
  }

  return 0;
}
