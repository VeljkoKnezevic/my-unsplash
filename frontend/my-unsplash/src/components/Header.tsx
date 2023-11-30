export default function Header() {
  return (
    <header className="pt-8 lg:px-24 xl:px-30 flex">
      <img src="/my_unsplash_logo.svg" alt="Logo" />
      <form className="pl-6">
        <input
          className="py-[18px] bg-[url('/search.svg')] bg-no-repeat"
          type="text"
          placeholder="Search by name"
        />
      </form>
      <button className="ml-auto text-white ">Add a photo</button>
    </header>
  );
}
