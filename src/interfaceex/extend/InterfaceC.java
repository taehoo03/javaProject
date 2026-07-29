package interfaceex.extend;

public interface InterfaceC extends InterfaceA, InterfaceB{
		public void methodC();
		
		@Override
		public void methodB() {
			System.out.println("CImplemnt")
		}
}
