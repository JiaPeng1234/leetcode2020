class Mergesort:
  def mergesort(self, array, left, right):
    if left == right:
      return
    middle = int((left+right) / 2)
    self.mergesort(array, left, middle)
    self.mergesort(array, middle + 1, right)
    self.merge(array, left, right, middle)
    
  def merge(self, array, left, right, middle):
    helper = array[:]
    current, leftHead, rightHead = left, left, middle + 1
    while leftHead <= middle and rightHead <= right:
      if helper[leftHead] <= helper[rightHead]:
        array[current] = helper[leftHead]
        leftHead += 1
      else:
        array[current] = helper[rightHead]
        rightHead += 1
      current += 1
    for remain in range(leftHead, middle + 1):
      array[current] = helper[remain]
      current += 1
      
def main():
  array = [3, 4, 9, 2]
  Mergesort().mergesort(array, 0, len(array) - 1)
  print(array)
  
if __name__ == '__main__':
  main()
